import axios from 'axios';

class ApiController {
  constructor(config) {
    this.config = config;
    this.initialState = {
      status: null,
      data: null,
      error: null,
    };
  }

  fetch = config => dispatch =>
    dispatch({
      type: 'API',
      payload: { ...this.config, ...config },
    });

  clear = () => dispatch =>
    dispatch({
      type: `${this.config.prefix}_CLEAR`,
    });

  reducer = (state = this.initialState, action) => {
    switch (action.type) {
      case `${this.config.prefix}_REQUEST`:
      case `${this.config.prefix}_SUCCESS`:
      case `${this.config.prefix}_FAILURE`:
        return {
          ...action.payload,
        };
      case `${this.config.prefix}_CLEAR`:
        return {
          ...this.initialState,
        };
      default:
        return state;
    }
  };

  static methods = {
    GET: 'get',
    POST: 'post',
    PUT: 'put',
    DELETE: 'delete',
  };

  static apiMiddleware({ dispatch }) {
    return next => action => {
      if (action.type !== 'API') {
        return next(action);
      }

      const config = action.payload;

      const urlPostfix = config.urlPostfix ? `/${config.urlPostfix}` : '';

      dispatch({
        type: `${config.prefix}_REQUEST`,
        payload: {
          status: 'REQUEST',
          data: null,
          error: null,
        },
      });

      return axios({
        method: config.method,
        url: config.url + urlPostfix,
      })
        .then(response => {
          if (response.status >= 400) {
            throw new Error(response.statusText);
          }
          dispatch({
            type: `${config.prefix}_SUCCESS`,
            payload: {
              status: 'SUCCESS',
              data: response.data,
              error: null,
            },
          });
        })
        .catch(error => {
          dispatch({
            type: `${config.prefix}_FAILURE`,
            payload: {
              status: 'FAILURE',
              data: null,
              error: error.message,
            },
          });
        });
    };
  }
}

export default ApiController;
