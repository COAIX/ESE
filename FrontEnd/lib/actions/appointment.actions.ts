"use server";

import axios from 'axios';

import { revalidatePath } from "next/cache";
import { ID, Query } from "node-appwrite";

import { Appointment } from "@/types/appwrite.types";

import {
  APPOINTMENT_COLLECTION_ID,
  DATABASE_ID,
  databases,
  ENDPOINT,

} from "../appwrite.config";
import { formatDateTime, parseStringify } from "../utils";

//  CREATE APPOINTMENT
export const createAppointment = async (appointment: CreateAppointmentParams) => {
  try {
    // Generate a unique appointmentId
    const appointmentId = ID.unique();

    // Add the unique appointmentId to the appointment object
    const appointmentData = { ...appointment, appointmentId };
    const response = await axios.post(`${ENDPOINT}/appointment`, appointmentData);

    revalidatePath("/admin");
    return parseStringify(response.data); // Assuming parseStringify is a function to format or handle the response
  } catch (error) {
    console.error("An error occurred while creating a new appointment:", error);
  }
};



//  GET RECENT APPOINTMENTS
export const getRecentAppointmentList = async () => {
  try {
    const response = await axios.get(`${ENDPOINT}/appointment/all`);
    const appointments = response.data; // Assuming the response data is the array of appointments

    const initialCounts = {
      scheduledCount: 0,
      pendingCount: 0,
      cancelledCount: 0,
    };

    const counts = appointments.reduce((acc: { scheduledCount: number; pendingCount: number; cancelledCount: number; }, appointment: { status: any; }) => {
      switch (appointment.status) {
        case "scheduled":
          acc.scheduledCount++;
          break;
        case "pending":
          acc.pendingCount++;
          break;
        case "cancelled":
          acc.cancelledCount++;
          break;
      }
      return acc;
    }, initialCounts);

    const data = {
      totalCount: appointments.length,
      ...counts,
      documents: appointments,
    };


    return parseStringify(data); // Assuming parseStringify is a function to format or handle the response
  } catch (error) {
    console.error("An error occurred while retrieving the recent appointments:", error);
  }
};



//  UPDATE APPOINTMENT
export const updateAppointment = async ({
                                          appointmentId,
                                          userId,
                                          appointment,
                                          type,
                                        }: UpdateAppointmentParams) => {
  try {
    // Include appointmentId in the appointment object
    const appointmentData = { ...appointment, appointmentId };

    const url = `${ENDPOINT}/appointment`;

    const response = await axios.put(url, appointmentData);


    revalidatePath("/admin");
    return parseStringify(response.data); // Assuming parseStringify is a function to format or handle the response
  } catch (error) {
    console.error("An error occurred while updating the appointment:", error);
  }
};


// GET APPOINTMENT
export const getAppointment = async (appointmentId: string) => {
  try {
    const response = await axios.get(`${ENDPOINT}/appointment/${appointmentId}`);
    return parseStringify(response.data); // Assuming parseStringify is a function to format or handle the response
  } catch (error) {
    console.error("An error occurred while retrieving the appointment:", error);
  }
};
