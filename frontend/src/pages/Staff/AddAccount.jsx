import React from 'react'

const AddAccount = () => {
  return (
    <div className="bg-white shadow-md rounded px-4 py-4">
    <h2 className="text-xl font-semibold mb-2">New Applicant</h2>
    <form>
      <div className="grid grid-cols-2 gap-4 mb-4">
        <div>
          <label htmlFor="firstName" className="block text-gray-700 font-bold mb-1">
            First Name
          </label>
          <input
            type="text"
            id="firstName"
            className="regInput"
          />
        </div>
        <div>
          <label htmlFor="lastName" className="block text-gray-700 font-bold mb-1">
            Last Name
          </label>
          <input
            type="text"
            id="lastName"
            className="regInput"
          />
        </div>
      </div>
      <div className="grid grid-cols-2 gap-4 mb-4">
        <div>
          <label htmlFor="firstName" className="block text-gray-700 font-bold mb-1">
            Preferred Username
          </label>
          <input
            type="text"
            id="firstName"
            className="regInput"
          />
        </div>
        <div>
          <label htmlFor="lastName" className="block text-gray-700 font-bold mb-1">
            Email
          </label>
          <input
            type="text"
            id="lastName"
            className="regInput"
          />
        </div>
      </div>
      <div className="mb-4">
        <label htmlFor="phone" className="block text-gray-700 font-bold mb-1">
          Phone Number
        </label>
        <input
          type="text"
          id="phone"
          className="regInput"
        />
      </div>
      <button
        type="submit"
        className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none mt-2"
      >
        Create Account
      </button>
    </form>
  </div>
  )
}

export default AddAccount
