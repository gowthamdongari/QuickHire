import React from "react";
import { Route, Routes } from "react-router-dom";
import SignIn from "./auth/SignIn";
import SignUp from "./auth/signUp";
import LandingPage from "./auth/LandingPage";
import Home from "./pages/Home";
import "./globals.css";
import Category from "./components/Category";
import Profiles from "./pages/Staff/Profiles";
import RegistrationPage from "./auth/Forms/RegistrationPage";
import Education from "./auth/Forms/Education";
import PaymentHistory from "./components/Payments/PaymentHistory";
import ProfessionalJobListingPage from "./components/ProfessionalProfile/ProfessionalJobListingPage";
import JobPosting from "./components/Employer/JobPosting";
import AddAccount from "./pages/Staff/AddAccount";
import StaffAccounts from "./pages/Staff/StaffAccounts";
import Notifications from "./pages/Notifications";
import IndividualPage from "./pages/Staff/IndividualPage";
import AccountSettings from "./components/AccountSettings";
import JobLists from "./pages/JobLists";
import IndividualJob from "./pages/IndividualJob";
import Settings from "./pages/common/Settings";
import PasswordChange from "./pages/common/PasswordChange";

const App = () => {
  return (
    <Routes>
      <Route index element={<LandingPage />} />

      <Route path="/SignIn" element={<SignIn />} />
      <Route path="/SignUp" element={<SignUp />} />
      <Route path="/qualifications" element={<Category />} />
      <Route path="/RegistrationPage" element={<RegistrationPage />} />
      <Route path="/education" element={<Education />} />
      <Route path="/category" element={<Category />} />

      <Route path="/home" element={<Home />}>
        {/* childrens */}
        {/* Staff routes starts here */}
        <Route
          path="/home/professionalReviews"
          element={
            <Profiles customerType={"Professional"} viewType={"review"} />
          }
        />
        <Route
          path="/home/empolyerReviews"
          element={<Profiles customerType={"Empolyer"} viewType={"review"} />}
        />
        <Route
          path="/home/ProfessionalLists"
          element={<Profiles customerType={"Professional"} viewType={"list"} />}
        />
        <Route
          path="/home/empolyerLists"
          element={<Profiles customerType={"Empolyer"} viewType={"list"} />}
        />

        {/* Staff routes end here */}

        <Route path="/home/notifications" element={<Notifications />} />
        <Route path="/home/settings/createAccount" element={<AddAccount />} />
        <Route
          path="/home/settings/staffAccounts"
          element={<StaffAccounts />}
        />
        <Route path="/home/individual" element={<IndividualPage />} />
        <Route path="/home/PaymentHistory" element={<PaymentHistory />} />
        <Route
          path="/home/ProfessionalJobListingPage"
          element={<ProfessionalJobListingPage />}
        />
        <Route path="/home/JobPosting" element={<JobPosting />} />
        <Route path="/home/AccountSettings" element={<AccountSettings />} />

        <Route path="/home/JobLists" element={<JobLists />} />
        <Route
          path="/homeJobLists/JobDescription"
          element={<IndividualJob />}
        />

        
        {/* common routes start here */}
        <Route path="/home/settings" element={<Settings />} />
        <Route path="/home/PasswordChange" element={<PasswordChange />} />  
        {/* common routes end here */}
      </Route>
    </Routes>
  );
};

export default App;
