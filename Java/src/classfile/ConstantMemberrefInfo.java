package classfile;

/**
 * Author: zhangxin
 * Time: 2017/5/2 0002.
 * Desc:
 * CONSTANT_Fieldref_info表示字段符号引用
 * CONSTANT_Methodref_info表示普通（非接口）方法符号引用
 * CONSTANT_InterfaceMethodref_info表示接口方法符号引用
 * 这三种类型结构一样,所以给出统一的类结构;
 * 然后定义三个类继承这个超类;
 */
public class ConstantMemberRefInfo extends ConstantInfo {
    ConstantPool constantPool;
    int classIndex;
    int nameAndTypeIndex;

    public ConstantMemberRefInfo(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    void readInfo(ClassReader reader) {
        classIndex = reader.readUint16();
        nameAndTypeIndex = reader.readUint16();
    }

    String getClassName() {
        return constantPool.getClassName(classIndex);
    }
    String[] getNameAndDescriptor(){
        return constantPool.getNameAndType(nameAndTypeIndex);
    }



    //下面两个方法是将上面的单独分开拿出来的,
    String getName() {
        return constantPool.getName(nameAndTypeIndex);
    }

    String getDescriptor() {
        return constantPool.getType(nameAndTypeIndex);
    }


}