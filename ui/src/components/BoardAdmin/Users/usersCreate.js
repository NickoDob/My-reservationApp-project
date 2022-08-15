import React from "react";
import {SimpleForm, SelectInput, TextInput, PasswordInput, Create, required, email, minLength} from 'react-admin';

const validateName = required();
const validateLastName = required();
const validatePosition = required();
const validateEmail = [required(), email()];
const validatePassword = [required(), minLength(8)];
const validateConfirmPassword = (value, allValues) => {
    if (!value) return 'ra.validation.required';
    if (value.length < 8) return {
      message: 'ra.validation.minLength',
      args: {min: 8}
    }
    if (allValues.password != value
    )
      return 'Введенные пароли не совпадают';

    return undefined;
  }
;

const choices = [
    { id: 1, value: 'Пользователь' },
    { id: 2, value: 'Администратор' },
];

const UserCreate = props => (
  <Create {...props} title="Создание нового пользователя">
    <SimpleForm>
      <TextInput source='name' label="Имя" validate={validateName}/>
      <TextInput source='lastName' label="Фамилия" validate={validateLastName}/>
      <TextInput source='position' label="Должность" validate={validatePosition}/>
      <TextInput source='email' label="Почта" validate={validateEmail}/>
      <PasswordInput source='password' label="Пароль" validate={validatePassword}/>
      <PasswordInput source='confirmPassword' label="Подтверждение пароля" validate={validateConfirmPassword}/>
      <SelectInput source="roleId" label="Роль" choices={choices} optionText="value" optionValue="id" />
    </SimpleForm>
  </Create>
);
//      <ReferenceInput label="Роль" source='role' reference="users">
//            <SelectInput optionText="role" />
//      </ReferenceInput>

export default UserCreate