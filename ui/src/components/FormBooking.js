import React, {useEffect, useState} from 'react'
import Toast from "react-bootstrap/Toast";
import './Home.css'
import Header from './Header'
import MyCalendar from '../MyCalendar';
import EventForm from "./EventForm";
import FilterForm from "./FilterForm";
import './FormBooking.css'

import filterFactory, { textFilter } from 'react-bootstrap-table2-filter';

import EventService from "../services/event.service";
import UserService from "../services/user.service";
import ItemService from "../services/item.service";
import AuthService from "../services/auth.service";
import {defaultEvent, defaultOrgUser, defaultItem} from "../components/DefaultValues";

import Select, {placeholder} from 'react-select'

import moment from 'moment';
import 'moment/locale/ru';
import './styles.css';

import BootstrapTable, {TableHeaderColumn } from 'react-bootstrap-table-next';
import 'react-bootstrap-table-next/dist/react-bootstrap-table2.min.css';
import ToolkitProvider, { Search } from 'react-bootstrap-table2-toolkit';
import paginationFactory from 'react-bootstrap-table2-paginator';

const FormBooking = () => {

  const [eventList, setEventList] = useState([]);
  const [filteredEventList, setFilteredEventList] = useState([]);

  const [isModalVisible, setIsModalVisible] = React.useState(false);
  const [isNotificationVisible, setIsNotificationVisible] = React.useState(false);
  const [isDeleteButtonVisible, setIsDeleteButtonVisible] = React.useState(false)

  const [editEventData, setEditEventData] = React.useState(defaultEvent);
  const [orgUserData, setOrgUserData] = React.useState(defaultOrgUser);
  const [itemList, setItemList] = React.useState([]);
  const [formData, setFormData] = React.useState({
      startDateTime: "null",
      endDateTime: "null",
      members: "",
      itemID: "",
      description: ""
    })

  const [successfulAddEvent, setSuccessfulAddEvent] = useState(false);
  const [message, setMessage] = useState("");

  const currentUser = AuthService.getCurrentUser();

  const handleAddEvent = (formData) => {
    setMessage("");
    setIsNotificationVisible(false)
    setSuccessfulAddEvent(false);

    EventService.add(
      formData.startDateTime.replace('T', ' '),
      formData.endDateTime.replace('T', ' '),
      formData.orgUserID,
      formData.members ? formData.members.map(x => x.value) : "[]",
      formData.itemID.value,
      formData.description
    ).then(
      (response) => {
        setMessage(response.data.message);
        setIsNotificationVisible(true)
        setSuccessfulAddEvent(true);
      },
      (error) => {
        const resMessage =
          (error.response &&
            error.response.data &&
            error.response.data.message) ||
          error.message ||
          error.toString();

        setMessage(resMessage);
        setIsNotificationVisible(true)
        setSuccessfulAddEvent(false);
      }
    );
  };

  async function getItemList() {
        try {
          const response = await ItemService.getItems();
          const parsedList = response.data && response.data.map((item) => {
            return {
              value: item.id,
              label: `${item.address}`,
              square: `${item.square}`,
              heating: `${item.heating}`,
              price: `${item.price}`
            }
          })
          setItemList(parsedList);
        } catch (err) {
          console.log(err, "API ERROR");
        }
      }

  useEffect(() => {
    document.title = 'Бронирование помещения';
    getItemList();
  }, []);

  const [sortConfig, setSortConfig] = React.useState(null);

    const sortedItems = React.useMemo(() => {
      let sortableItems = [...itemList];
      if (sortConfig !== null) {
        sortableItems.sort((a, b) => {
          if (a[sortConfig.key] < b[sortConfig.key]) {
            return sortConfig.direction === 'ascending' ? -1 : 1;
          }
          if (a[sortConfig.key] > b[sortConfig.key]) {
            return sortConfig.direction === 'ascending' ? 1 : -1;
          }
          return 0;
        });
      }
      return sortableItems;
    }, [itemList, sortConfig]);

  const getClassNamesFor = (name) => {
    if (!sortConfig) {
      return;
    }
    return sortConfig.key === name ? sortConfig.direction : undefined;
  };

  const selectOptions = {
    0: 'с отоплением',
    1: 'без отопления'
  };

  const columns = [{
    dataField:'value',
    text: 'ID'
  },
  {
     dataField:'label',
     text: 'Адрес',
     filter: textFilter({
        placeholder: 'Поиск'
     }),
     sort: true
  },
  {
     dataField:'heating',
     text: 'Отопление',
     filter: textFilter({
         placeholder: 'Поиск'
       }),
     sort: true
  },
  {
     dataField:'square',
     text: 'Площадь (м2)',
     filter: textFilter({
                                placeholder: 'Поиск'
                              }),
     sort: true
  },
  {
     dataField:'price',
     text: 'Стоимость (руб./сут.)',
     filter: textFilter({
                                placeholder: 'Поиск'
                              }),
     sort: true
    }];

  const defaultSorted = [{
    dataField: 'label',
    order: 'desc'
  }];

    const onChangeDescription = (e) => {
      const description = e.target.value;
      let formDataCopy = {...formData}
      formDataCopy.description = description;
      setFormData(formDataCopy);
    };

  const rowEvents = {
   onClick: (e, row, RowIndex) => {
     setFormData({
        description: "itemList[RowIndex].address"
     });
   }
  };

  const options = {
      page: 1,
      sizePerPage: 5,
      nextPageText: '>',
      prePageText: '<',
      showTotal: true
    };


  return (
    <div>
      <Header/>
      <div className="container">
        <div className="row">
          <div className="col-md-3 eventForm">
            <EventForm
                successful={successfulAddEvent}
                handleAddEvent={handleAddEvent}
            />
          </div>
          <div className="calendar col-md-9 mb-5">
           <ToolkitProvider
             bootstrap4
             keyField="id"
             data={ itemList }
             columns={ columns }
             //search
             exportCSV={{ onlyExportFiltered: true, exportAll: false }}
           >
             {
               props => (
                 <div>

                   <hr />
                   <BootstrapTable
                     rowEvents={ rowEvents }
                     defaultSorted={ defaultSorted }
                     { ...props.baseProps }
                     pagination={ paginationFactory(options) }
                     filter={ filterFactory()}
                   />
                 </div>
               )
             }
           </ToolkitProvider>
          </div>
        </div>
      </div>
      {message ? (
        <Toast className="notificationMessage" onClose={() => setIsNotificationVisible(false)}
               show={isNotificationVisible} delay={5000} autohide>
          <Toast.Header closeButton={false}>
            <strong className="me-auto">Сообщение</strong>
            <small className="text-muted">{moment().toNow(true)}</small>
          </Toast.Header>
          <Toast.Body>{message}</Toast.Body>
        </Toast>
      ) : null}
    </div>
  )
}

export default FormBooking;