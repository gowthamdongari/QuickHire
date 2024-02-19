export const validateUsername = (val, customMsg) => {
  try {
    const regex = /^[A-Za-z][A-Za-z0-9]{7,}$/;
    return regex.test(val)
      ? ""
      : customMsg ||
          "Username Name must start with an Alphabet and at least eight characters ";
  } catch (error) {
    return error;
  }
};

export const validatePassword = (password, customMsg) => {
  try {
    const regex =
      /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]).{8,}$/;
    return regex.test(password)
      ? ""
      : customMsg ||
          "Password must be atleast eight characters long, it should include at least one alphabet,one numerical and one special characters";
  } catch (error) {
    return error;
  }
};
