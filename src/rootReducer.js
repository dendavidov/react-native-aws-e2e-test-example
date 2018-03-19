import { combineReducers } from 'redux';
import { userReducer as user } from './modules/app/apiController';

const rootReducer = combineReducers({
  user,
});

export default rootReducer;
