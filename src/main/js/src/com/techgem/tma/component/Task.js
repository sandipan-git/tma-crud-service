import React, { Component } from 'react';
import TextField from '@material-ui/core/TextField';
import { makeStyles } from '@material-ui/core/styles';



  

class Task extends Component {
   
    
    render() {

        return (
          <div className='add-update-task-view'>
              <TextField required id="standard-required" label="Task Description" />
              <TextField
    id="date"
    label="Scheduled On"
    type="date"
    InputLabelProps={{
      shrink: true,
    }}
  />
          </div>
    )
  }
}

export default Task;