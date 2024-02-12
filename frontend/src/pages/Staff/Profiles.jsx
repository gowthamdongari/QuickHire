import React from 'react'
import IndividualProfile from '../../components/StaffComponents/IndividualProfile'

const Profiles = () => {
  return (
    <div className='grid grid-cols-3 gap-4'>
        <IndividualProfile />
        <IndividualProfile />
        <IndividualProfile />
        <IndividualProfile />
        <IndividualProfile />
        <IndividualProfile />
    </div>
  )
}

export default Profiles