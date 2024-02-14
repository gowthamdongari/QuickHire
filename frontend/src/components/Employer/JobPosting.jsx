import React from 'react'
import { FiMail, FiPlusCircle } from 'react-icons/fi';

const JobPosting = () => {
   
  return (
    <div className="bg-gray-50 min-h-screen flex justify-center items-center">
      <div className="bg-white rounded-lg shadow-lg p-8 m-2 max-w-2xl w-full">
        <h1 className="text-xs font-semibold mb-2">Position</h1>
        <input
          className="mb-2 w-full px-3 py-2 border rounded shadow appearance-none text-grey-darker"
          type="text"
          placeholder="Name of Position ex: Software Engineer"
        />

        <div className="flex flex-wrap -mx-2 mb-2">
          <div className="w-full md:w-1/2 px-2 mb-2 md:mb-0">
            <h1 className='text-xs font-semibold mb-2'>First Name</h1>
            <input
              className="w-full px-3 py-2 border rounded shadow appearance-none text-grey-darker"
              type="text"
              placeholder="First Name"
            />
          </div>
          <div className="w-full md:w-1/2 px-2">
            <h1 className='text-xs font-semibold mb-2'>Last Name</h1>
            <input
              className="w-full px-3 py-2 border rounded shadow appearance-none text-grey-darker"
              type="text"
              placeholder="Last Name"
            />
          </div>
        </div>
          <div className="flex mb-2">
            <div className="w-1/2 mr-1">
            <h1 className='text-xs font-semibold mb-2'>Email</h1>
            <input
              className="w-full px-3 py-2 border rounded shadow appearance-none text-grey-darker"
              type="email"
              placeholder="Email"
            />
          </div>
          <div className="w-1/2 ml-1">
            <div className="relative">
            <div className="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
              <FiMail className="text-gray-500" />
            </div>
              <h1 className='text-xs font-semibold mb-2'>Pay Per Hour</h1>
              <input
                className="w-full px-3 py-2 border rounded shadow appearance-none text-grey-darker pl-10"
                type="text"
                placeholder="Enter pay per hour in $"
              />
            </div>
          </div>
          </div>
          <div className="flex flex-wrap -mx-2 mb-2">
          <div className="w-full md:w-1/2 px-2 mb-2 md:mb-0">
          <div className="flex flex-row">
            <div className="flex justify-between">
                <label htmlFor="start-date" className='text-xs font-semibold mb-2'>Start Date:</label>
                <input type="date" id="start-date" className="px-4 border rounded p-2 shadow appearance-none text-grey-darke" />
            </div>
            <div className="flex justify-between">
                <label htmlFor="end-date" className='text-xs font-semibold m-2'>End Date:</label>
                <input type="date" id="end-date" className="px-4border rounded p-2 shadow appearance-none text-grey-darke" />
            </div>
            </div>
            </div>
            </div>
            <div className="flex items-center justify-between mb-8">
            <div className="flex-1 ml-3">
            <button className="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded-full w-full">
              Save & Finish
            </button>
          </div>
            </div>
        </div>
        </div> 
  )
}

export default JobPosting
