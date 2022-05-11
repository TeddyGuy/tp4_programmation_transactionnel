import { useParams } from "react-router-dom";
import { Col, Row } from "react-bootstrap";
import { useEffect, useState } from "react";
import axios from "axios";
import DocumentLoanCardList from "../components/DocumentLoansCardList";
import useForceUpdate from "../hooks/useForceUpdate";
import { fetchDocuments, fetchDocumentsWithCriteria } from "../hooks/apiHooks";
import DocumentCardList from "../components/DocumentCardList";
import { emptyDocumentData } from "../model/Document";
import DocumentSearchForm from "../components/forms/DocumentSearchForm";


const ClientBorrowingHistory = () => {

    const {id} = useParams();
    const[client, setClient] = useState({});
    const[documentLoans, setDocumentLoans] = useState([]);
    const[documents, setDocuments] = useState([]); 
    const [update, forceUpdate] = useForceUpdate();
    const[searchFormData, setSearchFormData] = useState(emptyDocumentData);

    const searchFormHandler = async (e) => {
        e.preventDefault();
        forceUpdate()
    }

    const fetchClient = async () => {
        var clientFromServer;
        await axios.get("http://localhost:8080/clients/" + id).then((response) => {
            clientFromServer = response.data
        }); 
        return clientFromServer;
    }
    const fetchDocumentLoans = async () => {
        var documentLoansFromServer;
        await axios.get("http://localhost:8080/clients/" + id + "/borrowing-history").then((response) => {
            documentLoansFromServer = response.data
        }); 
        return documentLoansFromServer;
    }

    const returnDocument = async (documentLoan) => {
        await axios.post("http://localhost:8080/document-loans/" + documentLoan.id + "/return");
        forceUpdate();
    }

    const borrowDocument = async (documentId) => {
        await axios.post(
            "http://localhost:8080/document-loans/",
            { 
                clientId:client.id,
                documentId:documentId
            });
        forceUpdate();
    }

    useEffect(() => {
        const getClient = async () => {
            const clientFromServer = await fetchClient();
            setClient(clientFromServer);
        }
        const getDocumentLoans = async () => {
            const documentLoansFromServer = await fetchDocumentLoans();
            setDocumentLoans(documentLoansFromServer);
        }
        const getDocuments = async () => {
            const documentsFromServer = await fetchDocumentsWithCriteria(searchFormData);
            setDocuments(documentsFromServer);
        }
        getDocuments();
        getDocumentLoans();
        getClient();
    },[update])

    

    return(
        <>
            <h1 className="text-center mt-4">Historique d'emprunt de {client.firstName}, {client.lastName}</h1>
            <Row className="py-5 px-5 m-0">
                <Col>
                    <DocumentLoanCardList documentLoans={documentLoans} returnDocument={returnDocument}/>
                </Col>
                <Col>
                    <DocumentSearchForm formData={searchFormData} setFormData={setSearchFormData} formHandler={searchFormHandler}/>
                </Col>
                <Col>
                    <DocumentCardList documents={documents} mode={'borrow'} borrowDocument={borrowDocument}/>
                </Col>
            </Row>
        </>
    );
}

export default ClientBorrowingHistory;