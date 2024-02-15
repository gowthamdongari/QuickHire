import React from 'react'

const AddAccount = () => {
  return (
    <div className="bg-gray-50 min-h-screen flex justify-center w-full">
      <div className="bg-white rounded-lg shadow-lg p-8 m-4 max-w-2xl w-full">
        <div className='flex justify-center'>
            <h1 className="text-md font-semibold mb-4">New Applicant</h1>
          </div>
          <div className="flex flex-wrap -mx-2 mb-2">
          <div className="w-full md:w-1/2 px-2 mb-2 md:mb-0">
          <h1 className="text-xs font-semibold mb-2">First Name</h1>
          <input
            className="mb-2 w-full px-3 py-2 text-xs border rounded shadow appearance-none text-grey-darker"
            type="text"
            id="firstName"
            placeholder="First Name"
          />
        </div>
        <div className="w-full md:w-1/2 px-2 mb-2 md:mb-0">
            <h1 className="text-xs font-semibold mb-2">Last Name</h1>
          <input
            className="w-full px-3 py-2 text-xs border rounded shadow appearance-none text-grey-darker"
            type="text"
            id="lastName"
            placeholder="Last Name"
          />
        </div>
      </div>
      <div className="flex flex-wrap -mx-2 mb-2">
          <div className="w-full md:w-1/2 px-2 mb-2 md:mb-0">
          <h1 className="text-xs font-semibold mb-2">Preferred Username</h1>
          <input
            className="mb-2 w-full px-3 py-2 text-xs border rounded shadow appearance-none text-grey-darker"
            type="text"
            id="firstName"
            placeholder="Preferred Username"
          />
        </div>
        <div className="w-full md:w-1/2 px-2 mb-2 md:mb-0">
            <h1 className="text-xs font-semibold mb-2">Email</h1>
          <input
            className="w-full px-3 py-2 text-xs border rounded shadow appearance-none text-grey-darker"
            type="text"
            id="lastName"
            placeholder="Email"
          />
        </div>
      </div>
      <div className="flex flex-wrap">
      <h1 className="text-xs font-semibold mb-2">Phone No</h1>
        <input
          className="w-full px-3 py-2 text-xs border rounded shadow appearance-none text-grey-darker"
          type="text"
          id="phone"
          placeholder='Phone No'
        />
      </div>
      <button
        type="submit"
        className=" mt-8 flex w-full justify-center rounded-md bg-fbblue px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
      >
        Create Account
      </button>
    </div>
  </div>
  )
}

export default AddAccount
