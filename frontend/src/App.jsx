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
import PaymentHistory from "./components/Payments/PaymentHistory";
import ProfessionalJobListingPage from "./components/ProfessionalProfile/ProfessionalJobListingPage";
import JobPosting from "./components/Employer/JobPosting";
import Settings from "./pages/Settings";
import AddAccount from "./pages/Staff/AddAccount";
import StaffAccounts from "./pages/Staff/StaffAccounts";
import Notifications from "./pages/Notifications";
import IndividualPage from "./pages/Staff/IndividualPage";

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
         <Route path="/home/settings" element={<Settings />}/>
         <Route path="/home/notifications" element ={<Notifications />} />
         <Route path="/home/settings/createAccount" element={<AddAccount/>}/>
         <Route path="/home/settings/staffAccounts" element={ <StaffAccounts/> }/>
         <Route path="/home/individual" element ={<IndividualPage />}/>
         <Route path="/home/:type" element={<Profiles/>}/>
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
