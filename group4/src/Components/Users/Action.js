export const setUsers = (users) => {
    // users: is an array of user objects
    return {
      type: "SET_USERS",
      payload: users,
    };
  };
  