import React from 'react';
import {Edit, SelectInput, SimpleForm, TextInput, required } from 'react-admin';

const choices = [
    { name: "с отоплением", value: 'с отоплением' },
    { name: "без отопления", value: 'без отопления' },
];

const ItemEdit = props =>(
  <Edit {...props} title="Редактирование помещения">
    <SimpleForm>
      <TextInput disabled source='id' />
      <TextInput source='address' validate={required()}/>
      <SelectInput source="heating" choices={choices} optionText="value" optionValue="name" validate={required()} />
      <TextInput source='square' validate={required()}/>
      <TextInput source='price' validate={required()}/>
    </SimpleForm>
  </Edit>
);

export default ItemEdit