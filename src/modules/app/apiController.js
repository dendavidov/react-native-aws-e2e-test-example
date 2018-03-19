import ApiController from '../../ApiController';

const prefixes = {
  USER: 'USER',
};

const config = {
  prefix: prefixes.USER,
  url: 'http://jsonplaceholder.typicode.com/users',
  method: ApiController.methods.GET,
};

const userController = new ApiController(config);

export const fetchUser = id => userController.fetch({ urlPostfix: id });

export const { reducer: userReducer } = userController;
