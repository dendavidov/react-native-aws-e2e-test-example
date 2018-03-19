import React from 'react';
import { StyleSheet } from 'react-native';
import { Provider } from 'react-redux';
import App from './modules/app/App';

import createStore from './createStore';

const store = createStore();

export default class Root extends React.Component {
  render() {
    return (
      <Provider store={store}>
        <App />
      </Provider>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
