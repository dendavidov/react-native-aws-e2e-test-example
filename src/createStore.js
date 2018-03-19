import { applyMiddleware, compose, createStore } from 'redux';
import thunkMiddleware from 'redux-thunk';
import rootReducer from './rootReducer';

import ApiController from './ApiController';

const middlewares = [thunkMiddleware, ApiController.apiMiddleware];
const enhancers = [];

export default function configureStore(initialState = {}) {
  const store = createStore(
    rootReducer,
    initialState,
    compose(applyMiddleware(...middlewares), ...enhancers)
  );

  if (module.hot) {
    module.hot.accept('./rootReducer', () => {
      // eslint-disable-next-line global-require
      const nextRootReducer = require('./rootReducer').default;

      store.replaceReducer(nextRootReducer);
    });
  }

  return store;
}
