import { Box } from "lucide-react";
import React from "react";
import { FaUserTie, FaPhoneAlt } from "react-icons/fa"; // react-icons for professional icon
import { BsBank } from "react-icons/bs";
import { IoIosMail } from "react-icons/io";

const ProfessionalDetails = () => {
  return (
    <div>
      <div className="flex justify-center">
        <h1 className="font-extrabold text-2xl">Professional Details</h1>
      </div>
      <div className="flex flex-col">
        <div className="flex-shrink-0">
          <FaUserTie className="h-20 w-24" />
        </div>
        <div>
          <h3 className="text-xl font-semibold m-3">User Name</h3>
        </div>
      </div>
      <div className="flex flex-row justify-between">
        <div className="flex flex-col">
          <div className="flex flex-row text-base font-medium ">
            <h5 className="mr-3">First Name</h5>
            <h5>Last Name</h5>
          </div>
          <div className="text-gray-400 text-sm mt-1">
            <h5>Address: 5657, mcfarlein Blvd, Dallas, Texas, United States</h5>
          </div>
        </div>
        <div>
          <div className="flex flex-col mr-12 text-sm text-gray-600 font-normal">
            <div className="flex flex-row">
              <IoIosMail />
              <text className="ml-2"> Profesional@gmail.com</text>{" "}
            </div>
            <div className="flex flex-row mt-2">
            <FaPhoneAlt />

            <p className="ml-2">1234567890</p>
            </div>
          </div>
        </div>
      </div>

      {/* <div className="flex items-start justify-evenly">
        <button style={styles.Button}>Accept</button>
        <button style={styles.Button1}>Reject</button>
      </div> */}
    </div>
  );
};

export default ProfessionalDetails;
