import React from 'react';
import {Create, SelectInput, SimpleForm, TextInput, required} from 'react-admin';

const validateName = required();
const validateAddress = required();
const validateHeating = required();
const validateSquare = required();
const validatePrice = required();

const choices = [
    { name: "с отоплением", value: 'с отоплением' },
    { name: "без отопления", value: 'без отопления' },
];

const ItemCreate = props => (
  <Create {...props} title="Добавление нового помещения">
    <SimpleForm>
      <TextInput source='address' label="Адрес" validate={validateAddress} />
      <SelectInput source="heating" label="Отопление" choices={choices} optionText="value" optionValue="name" validate={validateHeating} />
      <TextInput source='square' label="Площадь" validate={validateSquare} />
      <TextInput source='price' label="Стоимость" validate={validatePrice} />
    </SimpleForm>
  </Create>
);

export default ItemCreate