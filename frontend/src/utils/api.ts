import axios from 'axios';
import { PatientRegisterRequest, PatientLoginRequest } from '@/types/api';

const api = axios.create({
  baseURL: process.env.NEXT_PUBLIC_API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
  withCredentials: true, // Enable sending cookies with requests
});

// Add CORS headers to all requests
api.interceptors.request.use((config) => {
  // Remove the Access-Control-Allow-Origin header from client-side requests
  // This header should only be set by the server
  delete config.headers['Access-Control-Allow-Origin'];
  return config;
});

export interface ApiResponse<T = any> {
  code: number;
  message: string;
  data?: T;
}

export const patientApi = {
  register: async (data: PatientRegisterRequest): Promise<ApiResponse> => {
    const response = await api.post<ApiResponse>('/patient/register', data);
    return response.data;
  },

  login: async (data: PatientLoginRequest): Promise<ApiResponse> => {
    const response = await api.post<ApiResponse>('/patient/login', data);
    return response.data;
  },

  getTreatments: async (): Promise<ApiResponse> => {
    const response = await api.get<ApiResponse>('/item/list');
    return response.data;
  },
}; 