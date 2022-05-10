import DocumentCard from "./DocumentCard";

const DocumentCardList = ({documents, setFormData}) => {
    return(
    <>
        {documents.map(
            (document) => (<DocumentCard key={document.id} document={document} mode={'edit'}/>))}
    </>
    );
}

export default DocumentCardList;