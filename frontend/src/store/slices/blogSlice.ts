import { createSlice, PayloadAction } from '@reduxjs/toolkit';

interface BlogState {
  title: string;
  photoUrl: string;
  slug: string;
}

const initialState: BlogState = {
  title: '',
  photoUrl: '',
  slug: '',
};

const blogSlice = createSlice({
  name: 'blog',
  initialState,
  reducers: {
    setBlogData: (state, action: PayloadAction<BlogState>) => {
      state.title = action.payload.title;
      state.photoUrl = action.payload.photoUrl;
      state.slug = action.payload.slug;
    },
  },
});

export const { setBlogData } = blogSlice.actions;
export default blogSlice.reducer;
