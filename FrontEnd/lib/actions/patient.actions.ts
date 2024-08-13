"use server";

import axios from "axios";

import {ID, InputFile, Query} from "node-appwrite";

import {
    BUCKET_ID,
    DATABASE_ID,
    ENDPOINT,
    PATIENT_COLLECTION_ID,
    PROJECT_ID,
    databases,
    storage,
    users,
} from "../appwrite.config";
import {parseStringify} from "../utils";

// CREATE APPWRITE USER
export const createUser = async (user: CreateUserParams) => {
    try {
        // Create new user using axios POST request
        let response = await axios.post(`${ENDPOINT}/user`, {
            userId: ID.unique(),
            email: user.email,
            phone: user.phone,
            name: user.name,
        });
        if (!response.data) { // Assuming the user is existing in the database
            response = await axios.get(`${ENDPOINT}/user/email/${user.email}`);
        }
        return parseStringify(response.data);
    } catch (error: any) {
        // Check existing user by making a GET request using axios
        if (error.response && error.response.status === 409) {
            const response = await axios.get(`${ENDPOINT}/user/email/${user.email}`);
            return parseStringify(response.data);
        }
        console.error("An error occurred while creating a new user:", error);
    }
};




// GET USER
export const getUser = async (userId: string) => {
    try {
        const response = await axios.get(`${ENDPOINT}/user/${userId}`);
        return parseStringify(response.data);
    } catch (error) {
        console.error("An error occurred while retrieving the user details:", error);
    }
};


// REGISTER PATIENT
export const registerPatient = async (patient: RegisterUserParams) => {
    try {
        // Generate a new unique patientId
        const patientId = ID.unique();

        // patient的patientId和user的userId是一样的
        // const patientId = user.userId;

        // Add the unique patientId to the patient object
        const patientData = { ...patient, patientId };

        // const response = await axios.post(`${ENDPOINT}/patient`, patientData);
        const response = await axios.put(`${ENDPOINT}/patient/userId`, patientData);

        return parseStringify(response.data); // Assuming parseStringify is a function to format or handle the response
    } catch (error) {
        console.error("An error occurred while creating a new patient:", error);
    }
};


// GET PATIENT
export const getPatient = async (userId: string) => {
    try {
        const response = await axios.get(`${ENDPOINT}/patient/userId/${userId}`);
        return parseStringify(response.data); // Assuming parseStringify is a function to format or handle the response
    } catch (error) {
        console.error("An error occurred while retrieving the patient details:", error);
    }
};