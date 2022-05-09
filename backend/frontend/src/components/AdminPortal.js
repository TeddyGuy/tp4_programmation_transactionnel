import { Col, Row, Spinner } from "react-bootstrap";
import axios from "axios";
import { useEffect, useState } from "react";
import DocumentCardList from "./DocumentCardList";

const AdminPortal = () => {
    const[documents, setDocuments] = useState([]);
    const[formData, setFormData] = useState({});

    useEffect(()=>{
        const getDocuments = async () => {
            const documentsFromServer = await fetchDocuments();
            setDocuments(documentsFromServer);
        }
        getDocuments();
    },[]);

    const fetchDocuments = async () => {
        var documentsFromServer;
        await axios.get("http://localhost:8080/documents").then((response) => {
            documentsFromServer = response.data
        }); 
        return documentsFromServer;
    }

    return(
    <>
        <Row className="py-5 px-5">
            <Col>
                {
                    documents.length > 0 ?
                    <DocumentCardList documents={documents}/> :
                    <Spinner className='m-auto' animation="border" variant="warning"/>
                }
                
            </Col>
            <Col>
            </Col>
        </Row>
    </>
    );
}

export default AdminPortal;