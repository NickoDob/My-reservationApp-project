import React, {useEffect, useState} from "react";
import {Admin, fetchUtils, Resource} from 'react-admin';
import jsonServerProvider from 'ra-data-json-server';
import Cookies from "js-cookie";
import authHeader from "../services/auth-header";
import polyglotI18nProvider from 'ra-i18n-polyglot';
import russianMessages from 'ra-language-russian';

import "./BoardAdmin.css"

import usersList from "./BoardAdmin/Users/usersList"
import usersCreate from "./BoardAdmin/Users/usersCreate"
import usersEdit from "./BoardAdmin/Users/usersEdit"
import itemsCreate from "./BoardAdmin/Items/itemsCreate"
import itemsEdit from "./BoardAdmin/Items/itemsEdit"
import itemsList from "./BoardAdmin/Items/itemsList"

import UserIcon from '@material-ui/icons/GroupOutlined';
import ItemIcon from '@material-ui/icons/CategoryOutlined';

import Header from './Header'

import { Link } from 'react-router-dom';
import MenuItem from '@mui/material/MenuItem';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import SettingsIcon from '@mui/icons-material/Settings';
import { AppBar, Logout, UserMenu, useUserMenu } from 'react-admin';
import { Layout } from 'react-admin';

import { forwardRef } from 'react';
import { useLogout } from 'react-admin';

const BoardAdmin = () => {

  const [users, setUsers] = useState();

  const API_URL = "http://localhost:3000/api";
  const fetchJson = (url, options = {}) => {
    if (!options.headers) {
      options.headers = new Headers({Accept: 'application/json'});
    }
    options.headers.set('Content-Type', 'application/json');
    options.headers.set('Csrf-Token', Cookies.get('csrfCookie'));
    options.headers.set('X-Auth-Token', authHeader());
    return fetchUtils.fetchJson(url, options);
  };

  const dataProvider = jsonServerProvider(API_URL, fetchJson);
  const i18nProvider = polyglotI18nProvider(() => russianMessages, 'ru', {allowMissing: true});

const MyLogoutButton = forwardRef((props, ref) => {
    var url = window.location.toString();
    var url1 = url.replace(/admin#/,'home');
    const handleClick = () => useLogout(window.location = url1);
    return (
        <MenuItem
            onClick={handleClick}
            ref={ref}
        >
        На главную
        </MenuItem>
    );
});

const MyAppBar = props => <AppBar {...props} userMenu={<MyLogoutButton />} />;

const MyLayout = props => <Layout {...props} appBar={MyAppBar} />;

  return (
    <Admin layout={MyLayout} dataProvider={dataProvider} i18nProvider={i18nProvider} title="Список пользователей">
      <Resource name="users" options={{ label: 'Пользователи' }} list={usersList} create={usersCreate} edit={usersEdit} icon={UserIcon}/>
      <Resource name="items" options={{ label: 'Склады' }} list={itemsList} create={itemsCreate} edit={itemsEdit} icon={ItemIcon}/>
    </Admin>
  )
};

export default BoardAdmin;