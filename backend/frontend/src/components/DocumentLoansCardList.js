import DocumentLoanCard from "./DocumentLoanCard";

const DocumentLoanCardList = ({documentLoans, returnDocument}) => {
    return(
        <>
            {
                documentLoans.map((documentLoan) => (
                        <DocumentLoanCard key={documentLoan.id} documentLoan={documentLoan} returnDocument={returnDocument}/>))
            }
        </>
    );
}

export default DocumentLoanCardList;