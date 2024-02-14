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
import ProfessionalDetails from "./components/ProfessionalProfile/ProfessionalDetails";
import Education from "./auth/Forms/Education";
import RegistrationPageProfessional from "./auth/Forms/RegistrationPageProfessional";
import PaymentHistory from "./components/Payments/PaymentHistory";
import ProfessionalJobListingPage from "./components/ProfessionalProfile/ProfessionalJobListingPage";
import JobPosting from "./components/Employer/JobPosting";
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
         <Route path="/home/notifcations" element={<Notifications/>}/>
         <Route path="/home/accountSettings" element={<AccountSettings/>}/>
         <Route path="/home/ProfessionalDetails" element={<ProfessionalDetails/>} />
         <Route path="/home/PaymentHistory" element={<PaymentHistory/>} />
         <Route path="/home/ProfessionalJobListingPage" element={<ProfessionalJobListingPage/>} />
         <Route path="/home/JobPosting" element={<JobPosting/>} />

      </Route>
    </Routes>
  );
};

export default App;
