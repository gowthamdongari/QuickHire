import React from "react";
import { Route, Routes } from "react-router-dom";
import SignIn from "./auth/SignIn";
import SignUp from "./auth/signUp";
import LandingPage from "./auth/LandingPage";
import Home from "./pages/Home";
import './globals.css';


const App = () => {
  return (
    <Routes>
      <Route index element={<LandingPage />} />
      <Route path="/SignIn" element={<SignIn />} />
      <Route path="/SignUp" element={<SignUp />} />
      <Route path="/home" element={<Home/>}>
          {/* childrens */}
         
      </Route>
    </Routes>
  );
};

export default App;
