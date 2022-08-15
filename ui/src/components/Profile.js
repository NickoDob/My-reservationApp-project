import React, {useEffect} from "react";
import AuthService from "../services/auth.service";
import Header from "./Header";
import ChangePasswordForm from "./ChangePasswordForm";
import './Profile.css'

const Profile = () => {
  const currentUser = AuthService.getCurrentUser();

  useEffect(() => {
    document.title = 'Профиль';
  });

  return (
    <div>
      <Header/>

      <body>
        <div className="container">
          <div className="row align-items-center">
            <div className="col-lg-5 offset-md-1">
              <div className="card" id='profileInfo'>
                <div className="card-body">
                  <div className="d-flex flex-column align-items-center text-center mb-2">
                    <img src="/avatar.png" className="rounded-circle" width="150"/>
                    <div className="mt-3">
                      <h4>{currentUser.userInfo.name + ' ' + currentUser.userInfo.lastName}</h4>
                      <p className="text-secondary mb-1">{currentUser.userInfo.email}</p>
                    </div>
                  </div>

                  <div className="container center-block">
                    <div className="row mb-1">
                      <div className="col"><h6 className="mb-0">Имя, Фамилия:</h6></div>
                      <div className="col text-secondary">{currentUser.userInfo.name + ' ' + currentUser.userInfo.lastName}</div>
                    </div>

                    <div className="row mb-1">
                      <div className="col"><h6 className="mb-0">E-mail:</h6></div>
                      <div className="col text-secondary">{currentUser.userInfo.email}</div>
                    </div>

                    <div className="row mb-1">
                      <div className="col"><h6 className="mb-0">Должность:</h6></div>
                      <div className="col text-secondary">{currentUser.userInfo.position}</div>
                    </div>

                    <div className="row">
                      <div className="col"><h6 className="mb-0">Права:</h6></div>
                      <div className="col text-secondary">{currentUser.userInfo.role == "Admin" ? "Администратор" : "Пользователь"}</div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div className="col-lg-4" id='changePassword'>
              <ChangePasswordForm/>
            </div>
          </div>
        </div>
      </body>
    </div>

  );
};

export default Profile;