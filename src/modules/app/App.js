import React from 'react';
import { connect } from 'react-redux';
import { StyleSheet, Text, View, Button, TextInput } from 'react-native';

import { fetchUser } from './apiController';

export class App extends React.Component {
  state = {
    id: '1',
  };

  handleClick = () => {
    this.props.fetchUser(this.state.id);
  };

  handleChange = id => this.setState({ id });

  render() {
    return (
      <View style={styles.container}>
        <TextInput
          accessibilityLabel="text"
          style={styles.input}
          onChangeText={this.handleChange}
          value={this.state.id}
          keyboardType="numeric"
        />
        <Button
          accessibilityLabel="button"
          onPress={this.handleClick}
          title="Load"
        />
        <Text style={styles.text}>{this.props.user.status}</Text>
        <Text style={styles.text}           accessibilityLabel="name">
          {this.props.user.data && this.props.user.data.name}
        </Text>
      </View>
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
  text: {
    height: 50,
  },
  input: {
    width: '80%',
    height: 40,
    borderColor: 'gray',
    borderWidth: 1,
    marginBottom: 10,
  },
});

const mapStateToProps = state => ({
  user: state.user,
});

const mapActionsToProps = dispatch => ({
  fetchUser: id => dispatch(fetchUser(id)),
});

export default connect(mapStateToProps, mapActionsToProps)(App);
