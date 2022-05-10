import DocumentCard from "./DocumentCard";

const DocumentCardList = ({documents, setFormData, mode, borrowDocument}) => {
    return(
    <>
        {console.log(mode)}
        {documents.map(
            (document) => (<DocumentCard key={document.id} document={document} mode={mode} setFormData={setFormData} borrowDocument={borrowDocument}/>))}
    </>
    );
}

export default DocumentCardList;