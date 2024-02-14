import React from 'react'

const EducationList = ({educationDetails}) => {
    
  return (
    <div>
      {
        educationDetails.length>0 &&  <div className="overflow-x-auto">
        <table className="table-auto w-full border-collapse border border-gray-800">
          <thead>
            <tr className="bg-gray-200">
              <th className="border border-gray-800 px-4 py-2">
                Education
              </th>
              <th className="border border-gray-800 px-4 py-2">Major</th>
              <th className="border border-gray-800 px-4 py-2">
                End Date
              </th>
            </tr>
          </thead>
          <tbody>
            { educationDetails && educationDetails.map((item, index) => (
              <tr
                key={index}
                className={index % 2 === 0 ? "bg-gray-100" : "bg-white"}
              >
                <td className="border border-gray-800 px-4 py-2">
                  {item.schoolName}
                </td>
                <td className="border border-gray-800 px-4 py-2">
                  {item.major}
                </td>
                <td className="border border-gray-800 px-4 py-2">
                  {item.endTime}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      }
    </div>
  )
}

export default EducationList
