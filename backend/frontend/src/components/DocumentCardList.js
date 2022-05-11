import DocumentCard from "./cards/DocumentCard";

const DocumentCardList = ({documents, setFormData, mode, borrowDocument}) => {
    return(
    <>
        {documents.map(
            (document) => (<DocumentCard key={document.id} document={document} mode={mode} setFormData={setFormData} borrowDocument={borrowDocument}/>))}
    </>
    );
}

export default DocumentCardList;