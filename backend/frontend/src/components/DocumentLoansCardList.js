import DocumentLoanCard from "./DocumentLoanCard";


const DocumentLoanCardList = ({documentLoans}) => {
    return(
        <>
            {
                documentLoans.map((documentLoan) => (
                        <DocumentLoanCard key={documentLoan.id} documentLoan={documentLoan}/>))
            }
        </>
    );
}

export default DocumentLoanCardList;