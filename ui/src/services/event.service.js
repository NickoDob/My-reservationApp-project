import axios from "axios";
import Cookies from "js-cookie";
import authHeader from "./auth-header";

const API_URL = "http://localhost:3000/api/";

// Создание события
const add = ( startDateTime, endDateTime, orgUserID, members, itemID, description) => {
    return axios.post(API_URL + "events",
        {
            startDateTime,
            endDateTime,
            orgUserID,
            members,
            itemID,
            description
        },
        {
            headers: {
                'Csrf-Token': Cookies.get('csrfCookie'),
                'Content-Type': 'application/json',
                'X-Auth-Token': authHeader(),
            }
        });
}


const getEvents = () => {
    return axios.get(API_URL + 'events',
        {
            headers: {
                "Csrf-Token": Cookies.get("csrfCookie"),
                'X-Auth-Token': authHeader(),
            },
        })
}


const deleteEvent = (id) => {
    return axios.delete(API_URL + "events/" + id,
        {
            headers: {
                'Csrf-Token': Cookies.get('csrfCookie'),
                'Content-Type': 'application/json',
                'X-Auth-Token': authHeader(),
            }
        });
}


export default {
    add,
    getEvents,
    deleteEvent,
}