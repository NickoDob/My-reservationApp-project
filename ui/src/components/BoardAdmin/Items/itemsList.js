import React from 'react';
import {Datagrid, List, Filter, TextField, TextInput, EditButton, FilterButton, ReferenceInput, SearchInput, CreateButton, TopToolbar } from 'react-admin';

const ItemEditButton = ({ record }) => (
  <EditButton basePath="/items" label="Изменить" record={record} />
);

const ItemsListActions = ({ basePath }) => (
  <TopToolbar>
    <CreateButton basePath={basePath} />
  </TopToolbar>
);


const postFilters = [
    <TextInput source="address" label="Адрес" alwaysOn />,
    <TextInput label="Отопление" source="heating" defaultValue="с отоплением" />,
    <TextInput label="Площадь" source="square" />,
    <TextInput label="Стоимость" source="price" />,
];


const TagFilter = (props) => (
  <Filter {...props}>
    <SearchInput source="address" resettable alwaysOn />
  </Filter>
)

const ItemList = props => (
  <List actions={<ItemsListActions />} {...props} >
    <Datagrid>
      <TextField source='address' label="Адрес" sortable={false}/>
      <TextField source='heating' label="Отопление" sortable={false} />
      <TextField source='square' label="Площадь" sortable={false} />
      <TextField source='price' label="Стоимость" sortable={false} />
      <ItemEditButton/>
    </Datagrid>
  </List>
);

export default ItemList