import React from "react";
import {Datagrid, EmailField, EditButton, List, SelectField, TextField, CreateButton, TopToolbar } from 'react-admin';

const rolesSelectChoices = [
  {role_type: "User", role_name: 'Пользователь'},
  {role_type: "Admin", role_name: 'Администратор'},
];

const UserEditButton = ({ record }) => (
  <EditButton basePath="/users" label="Изменить" record={record} />
);

const UsersListActions = ({ basePath }) => (
  <TopToolbar>
    <CreateButton basePath={basePath} />
  </TopToolbar>
);

const usersList = props => (
  <List actions={<UsersListActions />} {...props}>
    <Datagrid>
      <TextField source='name' label="Имя" sortable={false}/>
      <TextField source='lastName' label="Фамилия" sortable={false}/>
      <TextField source='position' label="Должность" sortable={false}/>
      <EmailField source='email' label="Почта" sortable={false}/>
      <SelectField source='role' label="Роль" choices={rolesSelectChoices} optionText="role_name" optionValue="role_type" sortable={false} />
      <UserEditButton />
    </Datagrid>
  </List>
);

export default usersList