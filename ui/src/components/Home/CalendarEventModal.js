import React from "react";

import {Modal, ModalBody, ModalFooter} from "react-bootstrap";
import ModalHeader from "react-bootstrap/ModalHeader";
import Moment from 'moment';

const CalendarEventModal = (props) => {

  const {isModalVisible, handleModalClose, handleDeleteEvent, isDeleteButtonVisible, eventData, itemData, orgUserData, deleteEvent} = props;

function Middler(start, end) {
    Moment.locale('en');

    var x0 = new Date(Moment(start).format().toString()).getTime();
    var x1 = new Date(Moment(end).format().toString()).getTime();
    var middle = Math.ceil(new Date(x1 - x0) / 86400000).toString();
    return middle
}

  return (
    <Modal
      show={isModalVisible}
      onHide={handleModalClose}
    >
      <ModalHeader>
        <h4 className="col-12 modal-title text-center">{eventData ? eventData.title : ""}</h4>
      </ModalHeader>
      <ModalBody>
        {eventData ? (
          <div>
            <p><b>Склад:</b> {itemData.address}</p>
            <p><b>Арендатор:</b> {orgUserData.name} {orgUserData.lastName}</p>
            <p><b>Время начала:</b> {eventData.start.toString()}</p>
            <p><b>Время окончания:</b> {eventData.end.toString()}</p>
            <p><b>Стоимость за период:</b> {Middler(eventData.start, eventData.end) * itemData.price} руб.</p>
            <p><b>Дополнительно:</b> {eventData.description}</p>
          </div>
        ) : null}
      </ModalBody>
      <ModalFooter>
        {isDeleteButtonVisible &&
        <button type="button" className="btn btn-danger" onClick={e => handleDeleteEvent(e, eventData.id)}>Удалить
          событие</button>}
        <button type="button" className="btn btn-primary" onClick={handleModalClose}>Закрыть</button>
      </ModalFooter>
    </Modal>
  );
}

export default CalendarEventModal;