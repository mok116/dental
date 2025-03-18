import { createSlice, PayloadAction } from "@reduxjs/toolkit";

interface DentistState {
  name: string;
  title: string;
  photoUrl: string;
  resumeUrl: string;
  slug:string;
}

const initialState: DentistState = {
  name: "",
  title: "",
  photoUrl: "",
  resumeUrl: "",
  slug:""
};

const dentistSlice = createSlice({
  name: "dentist",
  initialState,
  reducers: {
    setDentistData: (state, action: PayloadAction<DentistState>) => {
      state.name = action.payload.name;
      state.title = action.payload.title;
      state.photoUrl = action.payload.photoUrl;
      state.resumeUrl = action.payload.resumeUrl;
      state.slug = action.payload.slug;
    },
  },
});

export const { setDentistData } = dentistSlice.actions;
export default dentistSlice.reducer;
