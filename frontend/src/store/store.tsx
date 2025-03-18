import { configureStore } from '@reduxjs/toolkit';
import counterSlice from './slices/counterSlice';
import formSlice from './slices/formSlice';
import blogSlice from './slices/blogSlice';
import dentistSlice from "./slices/dentistSlice";

export const store = configureStore({
  reducer: {
    counter: counterSlice,
    form: formSlice,
    blog: blogSlice,
    dentist:dentistSlice
  },
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
