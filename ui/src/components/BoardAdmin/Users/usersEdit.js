import React from 'react';
import {Edit, Create, SelectField, ReferenceInput, SelectInput, SimpleForm, TextInput, PasswordInput, email, minLength, required} from 'react-admin';

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

const rolesSelectChoices = [
  {role_type: "User", role_name: 'Пользователь'},
  {role_type: "Admin", role_name: 'Администратор'},
];

const UserEdit = props =>(
  <Edit {...props} title="Редактирование пользователя">
    <SimpleForm>
          <TextInput source='name' label="Имя" validate={validateName}/>
          <TextInput source='lastName' label="Фамилия" validate={validateLastName}/>
          <TextInput source='position' label="Должность" validate={validatePosition}/>
          <TextInput source='email' label="Почта" validate={validateEmail}/>
          <PasswordInput source='password' label="Пароль" validate={validatePassword}/>
          <PasswordInput source='confirmPassword' label="Подтверждение пароля" validate={validateConfirmPassword}/>
    </SimpleForm>
  </Edit>
);

export default UserEdit