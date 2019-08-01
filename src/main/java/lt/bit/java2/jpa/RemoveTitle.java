package lt.bit.java2.jpa;

import lt.bit.java2.jpa.entities.Employee;
import lt.bit.java2.jpa.entities.Title;
import lt.bit.java2.jpa.entities.TitlePK;

public class RemoveTitle {
    public static void main(String[] args) {
        EntityManagerHelper.executeInTrasaction(em -> {
            Employee employee = em.find(Employee.class, 10004);

            String titleToRemoveName = "CEO";
            Title selectedTitle = RemoveTitle.getTitle(employee, titleToRemoveName);

/*
            Supplier<Title> tit = () -> {
                Title result = new Title();
                employee.getTitles().forEach(t->{
                    if (t.getTitle().equals(titleToRemoveName)){
                        result.setTitle(t.getTitle());
                        result.setFromDate(t.getFromDate());
                        result.setToDate(t.getToDate());
                        result.setEmployee(t.getEmployee());
                    }
                });
                return result;
            };
            Title selectedTitle = tit.get();
*/


            TitlePK tPK = new TitlePK();
            tPK.setEmployee(employee);
            tPK.setTitle(titleToRemoveName);
            tPK.setFromDate(selectedTitle.getFromDate());

            Title titleToRemove = em.find(Title.class, tPK);

            em.remove(titleToRemove);
            employee.getTitles().remove(titleToRemove);
        });
    }

    private static Title getTitle(Employee employee, String titleName){
        Title result = new Title();
        employee.getTitles().forEach(t->{
            if (t.getTitle().equals(titleName)){
                result.setTitle(t.getTitle());
                result.setFromDate(t.getFromDate());
                result.setToDate(t.getToDate());
                result.setEmployee(t.getEmployee());
            }
        });
        return result;
    }

}
