package interface_form;

public interface StackInterface <E>{

    /**
     *
     * @param item 스택에 추가된 요소
     * @return 추가된 요소
     */
    E push(E item);

    /**
     * 스택의 최상단에 위치한 요소 삭제
     * @return 삭제된 요소
     */
    E pop();

    /**
     * 스택의 최상단에 위치한 요소 반환
     * @return 요소반환
     */
    E peek();

    /**
     * 스택의 상단으로부터 특정요소가 몇번째에 위치했는지
     *
     * @param o 찾으려는 요소
     * @return 상단으로부터의 위치
     */
    /*
     *         ________
     *         | a    |
     * idx 3   |______|   search("w")
     *         | e    |   --> 상단(idx 3)으로 부터 3번 째에 위치
     * idx 2   |______|       == return 되는 값 : 3
     *         | w    |
     * idx 1   |______|
     *         | k    |
     * idx 0   |______|
     *
     */
    int search(Object o);

    /**
     * 스택이 비어있는지 확인한다.
     * @return 스택이 비어있으면 true , 스택이 비어있지 않으면 false
     */
    boolean empty();

    /**
     * 스택의 크기 반환
     * @return 스택의 크기
     */
    int size();

    /**
     * 스택을 비운다.
     */
    void clear();
}
