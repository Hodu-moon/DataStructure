package interface_form;

/**
 *
 * 자바 List Interface
 * List는 ArrayList, SinglyLinkedList, DoublyLinked 에 의해 각각 구현됩니다.
 *
 * @author hodu-moon
 * @param <E> the type of elements in this list
 *
 *  List는 중복을 허용하면서 저장순서가 유지된다.
 */
public interface List<E> {

    /**
     *  리스트에서 지정된 위치에 지정된 element를 삽입한다.
     *  지정된 위치 및 그뒤 element들은 한 칸씩 뒤로 밀린다.
     *
     *  Insert
     *
     * @param index 리스트에서 위치
     * @param element 추가될 element
     */
    void add(int index, E element);

    /**
     *  리스트의 마지막에 element 추가한다.
     *  Append
     *
     * @param element
     * @return 리스트에서 중복을 허용하지 않을 경우 중복되는 element가 있는 경우 false를 반환하고,
     *         중복되는 원소가 없을 경우 true를 반환한다.
     */
    boolean add(E element);

    /**
     *  index에 위치한 element 제거
     *
     * @param index list에서 제거할  element 위치
     * @return 제거된 element
     */
    E remove(int index);

    /**
     *  리스트에서 지정된 element를 제거한다. 처음만나는것
     *
     * @param value 리스트에서 삭제할 element
     * @return 리스트에서 삭제할 element가 없을 경우 false,
     *         삭제를 성공한 경우 true를 리턴함.
     */
    boolean remove(Object value);

    /**
     *  index에 위치한 element 를 반환한다.
     *
     * @param index 위치
     * @return index에 위치한 element
     */
    E get(int index);

    /**
     * index위치의 값을 element로 바꾼다.
     * 바뀌기 전 element를 반환한다.
     *
     * @param index 바꿀위치
     * @param value 대체할 element
     * @return
     */
    E set(int index, E value);

    /**
     *  리스트에 value가 있는지 확인하는 함수
     * @param value
     * @return 리스트가 value를 포함하고 있으면 true,
     *         포함하고 있지 않으면 false
     */
    boolean contains(Object value);

    /**
     *  리스트에서 처음으로 일치하는 지정된 element의 index를 반환하고, elemet가 포함되지 않았다면 -1을 반환한다.
     * @param o 위치를 알고싶은 element
     * @return element의 위치. element가 없으면 -1을 반환한다.
     */
    int indexOf(Object o);

    /**
     * 리스트의 사이즈를 반환함
     * @return 리스트의 사이즈를 반환한다.
     */
    int size();

    /**
     * 리스트가 비어있는지 확인
     * @return list가 비어있으면 true, 비어있지 않으면 false를 반환
     */
    boolean isEmpty();

    /**
     * 리스트의 element를 모두 제거한다.
     */
    void clear();


}
