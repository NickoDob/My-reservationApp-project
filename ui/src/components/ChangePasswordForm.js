import React, {useState, useRef} from "react";
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";
import "./EventForm.css";
import UserService from "../services/user.service"



// Требование заполненности поля
const required = value => {
    if (!value) {
        return (
            <div className="invalid-feedback d-block">
                Заполните поле
            </div>
        );
    }
};

const vpassword = value => {
    if (value.length < 8) {
        return (
            <div className="invalid-feedback d-block">
                Пароль должен содержать минимум 8 символов
            </div>
        );
    }
};


const ChangePassword = (props) => {

    const form = useRef();
    const checkBtn = useRef();

    const [currentPassword, setCurrentPassword] = useState("");
    const [newPassword, setNewPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");

    const [successful, setSuccessful] = useState(false);
    const [message, setMessage] = useState("");


    const onChangeCurrentPassword = (e) => {
        const currentPassword = e.target.value;
        setCurrentPassword(currentPassword);
    };

    const onChangeNewPassword = (e) => {
        const newPassword = e.target.value;
        setNewPassword(newPassword);
    };

    const onChangeConfirmPassword = (e) => {
        const confirmPassword = e.target.value;
        setConfirmPassword(confirmPassword);
    };


    const handleChangePassword = (e) => {
        e.preventDefault();

        setMessage("");
        setSuccessful(false);

        form.current.validateAll();

        if (checkBtn.current.context._errors.length === 0) {
            UserService.changePassword(currentPassword, newPassword, confirmPassword).then(
                (response) => {
                    setMessage(response.data.message);
                    setSuccessful(true);
                },
                (error) => {
                    const resMessage =
                        (error.response &&
                            error.response.data &&
                            error.response.data.message) ||
                        error.message ||
                        error.toString();

                    setMessage(resMessage);
                    setSuccessful(false);
                }
            );
        }
    };



    return (
        <div className="card card-container">
            <Form onSubmit={handleChangePassword} ref={form}>
                <div>
                    <div className="title-form">Изменение пароля</div>

                    <div className="form-group">
                        <label htmlFor="password">Действующий пароль:</label>
                        <Input
                            type="password"
                            className="form-control"
                            name="currentPassword"
                            value={currentPassword}
                            onChange={onChangeCurrentPassword}
                            validations={[required, vpassword]}
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="password">Новый пароль:</label>
                        <Input
                            type="password"
                            className="form-control"
                            name="newPassword"
                            value={newPassword}
                            onChange={onChangeNewPassword}
                            validations={[required, vpassword]}
                        />
                    </div>


                    <div className="form-group">
                        <label htmlFor="password">Подтвердите пароль:</label>
                        <Input
                            type="password"
                            className="form-control"
                            name="password"
                            value={confirmPassword}
                            onChange={onChangeConfirmPassword}
                            validations={[required, vpassword]}
                        />
                    </div>


                    <div className="form-group">
                        <button className="btn eventSubmitBtn btn-block btn-primary">Изменить</button>
                    </div>
                </div>

                <CheckButton style={{display: "none"}} ref={checkBtn}/>

                {message && (
                    <div className="form-group">
                        <div className={successful ? "alert alert-success" : "alert alert-danger"} role="alert">
                            {message}
                        </div>
                    </div>
                )}
            </Form>
        </div>
    );
}

//      const [name, setName] = useState("");
//      const [lastName, setLastName] = useState("");
//      const [position, setPosition] = useState("");
//      const [email, setEmail] = useState("");

//    const onChangeName = (e) => {
//        const name = e.target.value;
//        setName(name);
//      };

//      const onChangeLastName = (e) => {
//        const lastName = e.target.value;
//        setLastName(lastName);
//      };

//      const onChangePosition = (e) => {
//        const position = e.target.value;
//        setPosition(position);
//      };

//      const onChangeEmail = (e) => {
//        const email = e.target.value;
//        setEmail(email);
//      };

//                    <div className="form-group">
//                                  <label htmlFor="name">Имя:</label>
//                                  <Input
//                                    type="text"
//                                    className="form-control"
//                                    name="name"
//                                    value={name}
//                                    onChange={onChangeName}
//                                  />
//                                </div>

//                                <div className="form-group">
//                                  <label htmlFor="lastName">Фамилия:</label>
//                                  <Input
//                                    type="text"
//                                    className="form-control"
//                                    name="lastName"
//                                    value={lastName}
//                                    onChange={onChangeLastName}
//                                  />
//                                </div>

//                                <div className="form-group">
//                                  <label htmlFor="position">Должность:</label>
//                                  <Input
//                                    type="text"
//                                    className="form-control"
//                                    name="position"
//                                    value={position}
//                                    onChange={onChangePosition}
//                                  />
//                                </div>

//                                <div className="form-group">
//                                  <label htmlFor="email">E-mail:</label>
//                                  <Input
 //                                   type="text"
//                                    className="form-control"
//                                    name="email"
//                                    value={email}
//                                    onChange={onChangeEmail}
//                                  />
//                                </div>

export default ChangePassword;