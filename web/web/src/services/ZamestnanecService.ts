import {apiGet} from "../api/apiClient.ts";
import type {ZamestnanecDto} from "../models/ZamestnanecDto.ts";


export async function dejZamestnance(){
    return apiGet<ZamestnanecDto[]>("zamestnanec");
}