import {apiGet} from "../api/apiClient.ts";
import type {ProduktDto} from "../models/ProduktDto.ts";

export default async function dejProdukty(){
    return apiGet<ProduktDto[]>("produkty");
}