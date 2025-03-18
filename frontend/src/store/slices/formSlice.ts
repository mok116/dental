import { createSlice, PayloadAction } from '@reduxjs/toolkit';

interface FormState {
  firstName: string;
  lastName: string;
  phone: string;
  email: string;
  topic: string;
}

const initialState: FormState = {
  firstName: '',
  lastName: '',
  phone: '',
  email: '',
  topic: 'Fiyat',
};

const formSlice = createSlice({
  name: 'form',
  initialState,
  reducers: {
    setFormField(state, action: PayloadAction<{ field: keyof FormState; value: string }>) {
      state[action.payload.field] = action.payload.value;
    },
    resetForm(state) {
      return initialState;
    },
  },
});

export const { setFormField, resetForm } = formSlice.actions;
export default formSlice.reducer;
