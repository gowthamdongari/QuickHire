import React from "react";
import { Route, Routes } from "react-router-dom";
import SignIn from "./auth/SignIn";
import SignUp from "./auth/signUp";
import LandingPage from "./auth/LandingPage";
import Home from "./pages/Home";
import './globals.css';
import Category from "./components/Category";
import Profiles from "./pages/Staff/Profiles";
import RegistrationPage from "./auth/Forms/RegistrationPage";
import Education from "./auth/Forms/Education";
import RegistrationPageProfessional from "./auth/Forms/RegistrationPageProfessional";
import Settings from "./pages/Settings";
import AddAccount from "./pages/Staff/AddAccount";
import StaffAccounts from "./pages/Staff/StaffAccounts";

const App = () => {
  return (
    <Routes>
      <Route index element={<LandingPage />} />
      <Route path="/SignIn" element={<SignIn />} />
      <Route path="/SignUp" element={<SignUp />} />
      <Route path="/qualifications" element ={<Category/>}/>
      <Route path="/RegistrationPage" element={<RegistrationPage/>} /> 
      <Route path="/education" element={<Education/>} />

      <Route path="/RegistrationPageProfessional" element={<RegistrationPageProfessional/>} />
      <Route path="/home" element={<Home/>} >
          {/* childrens */}
         <Route path="/home/:type" element={<Profiles/>}/>
         <Route path="/home/settings" element={<Settings />}/>
         <Route path="/home/settings/createAccount" element={<AddAccount/>}/>
         <Route path="/home/settings/staffAccounts" element={ <StaffAccounts/> }/>
      </Route>
    </Routes>
  );
};

export default App;
