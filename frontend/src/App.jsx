import React from "react";
import { Route, Routes } from "react-router-dom";
import SignIn from "./auth/SignIn";
import SignUp from "./auth/signUp";
import LandingPage from "./auth/LandingPage";
import Home from "./pages/Home";
import './globals.css';
import JobList from "./components/JobList";
import Category from "./components/Category";
import Profiles from "./pages/Staff/Profiles";
import IndividualDetails from "./pages/IndividualDetails";
import Notifications from "./pages/Notifications";
import AccountSettings from "./pages/Staff/AccountSettings";
import AddAccount from "./pages/Staff/AddAccount";
import StaffAccounts from "./pages/Staff/StaffAccounts";
import RegistrationPage from "./auth/Forms/RegistrationPage";
import RegistrationPageProfessional from "./auth/Forms/RegistrationPageProfessional";

const App = () => {
  return (
    <Routes>
      <Route index element={<LandingPage />} />
      <Route path="/SignIn" element={<SignIn />} />
      <Route path="/SignUp" element={<SignUp />} />
      <Route path="/qualifications" element ={<Category/>}/>
      <Route path="/RegistrationPage" element={<RegistrationPage/>} />
      <Route path="/RegistrationPageProfessional" element={<RegistrationPageProfessional/>} />
      <Route path="/home" element={<Home/>} >
          {/* childrens */}
         <Route path="/home/viewJobs" element={<JobList/>}/>
         <Route path="/home/review" element={<Profiles/>}/>
         <Route path="/home/individual" element={<IndividualDetails/>}/>
         <Route path="/home/notifcations" element={<Notifications/>}/>
         <Route path="/home/accountSettings" element={<AccountSettings/>}/>

      </Route>
    </Routes>
  );
};

export default App;
