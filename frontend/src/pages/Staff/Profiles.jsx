import React from 'react'
import IndividualProfile from '../../components/StaffComponents/IndividualProfile'
import { useLocation, useParams } from 'react-router-dom'


function useQuery(){
  const {search} = useLocation();
  return React.useMemo(()=>new URLSearchParams(search),[search]);
}
const Profiles = () => {
  const {type} = useParams();
  const query = useQuery();
  const operation = query.get("op");
  return (
    <div className='grid grid-cols-3 gap-3'>
        <IndividualProfile OperationType={operation} customerType={type} />
        <IndividualProfile OperationType={operation} customerType={type}/>
        <IndividualProfile OperationType={operation} customerType={type}/>
        <IndividualProfile OperationType={operation} customerType={type}/>
        <IndividualProfile OperationType={operation} customerType={type}/>
        <IndividualProfile OperationType={operation} customerType={type}/>
    </div>
  )
}

export default Profiles