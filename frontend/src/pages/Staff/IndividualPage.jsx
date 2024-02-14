import React from 'react'
import ProfessionalDetails from '../../components/ProfessionalProfile/ProfessionalDetails';

const IndividualPage = () => {
  return (
    <div>
       <ProfessionalDetails/>
    </div>
  )
}

export default IndividualPage

const ProfilePage = () => {
  // Dummy data for the profile
  const profile = {
    firstName: 'Jane',
    lastName: 'Doe',
    phoneNumber: '123-456-7890',
    email: 'jane.doe@example.com',
    address: '1234 North Avenue, Springfield, IL',
    education: [
      {
        institution: 'Southern Methodist University',
        degree: 'Master of Science - Computer Engineering',
        period: 'Aug 2023 - May 2025',
      }
    ]
  };

  return (
    <div className="container mx-auto p-4">
      <div className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4">
        <div className="mb-6">
          <h1 className="text-xl font-bold text-gray-700">{profile.firstName} {profile.lastName}</h1>
        </div>
        <div className="mb-4">
          <h2 className="text-lg text-gray-700">Contact Information</h2>
          <p className="text-gray-600">Phone: {profile.phoneNumber}</p>
          <p className="text-gray-600">Email: {profile.email}</p>
          <p className="text-gray-600">Address: {profile.address}</p>
        </div>
        <div className="mb-6">
          <h2 className="text-lg text-gray-700">Education</h2>
          {profile.education.map((edu, index) => (
            <div key={index} className="mb-2">
              <p className="text-gray-600 font-bold">{edu.institution}</p>
              <p className="text-gray-600">{edu.degree}</p>
              <p className="text-gray-500">{edu.period}</p>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

